// 애플리케이션 메인 JavaScript 파일

// 전역 변수
let isAdminMode = false;
let isInitialized = false;

// Firebase DB 객체 가져오기
function getFirebaseDB() {
    if (typeof firebase !== 'undefined' && firebase.firestore) {
        try {
            return firebase.firestore();
        } catch (error) {
            console.error('Firestore 가져오기 오류:', error);
            return null;
        }
    }
    console.log('Firebase 또는 Firestore가 로드되지 않음');
    return null;
}

// DOM 로드 완료 후 실행
document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM 로드 완료');
    if (!isInitialized) {
        initializeApp();
        isInitialized = true;
    }
});

// 페이지 완전 로드 후에도 한 번 더 확인
window.addEventListener('load', function() {
    console.log('페이지 완전 로드');
    if (!isInitialized) {
        initializeApp();
        isInitialized = true;
    }
});

function initializeApp() {
    console.log('애플리케이션 초기화 시작');
    
    // 부드러운 스크롤 효과
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // 스크롤 시 헤더 스타일 변경
    window.addEventListener('scroll', function() {
        const header = document.querySelector('header');
        if (window.scrollY > 100) {
            header.style.background = 'rgba(102, 126, 234, 0.95)';
        } else {
            header.style.background = 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)';
        }
    });

    // 폼 제출 처리 - 중복 등록 방지
    const form = document.getElementById('applyForm');
    if (form) {
        // 기존 이벤트 리스너 제거
        form.removeEventListener('submit', handleFormSubmit);
        // 새로운 이벤트 리스너 등록
        form.addEventListener('submit', handleFormSubmit);
        console.log('폼 이벤트 리스너 등록 완료');
    }

    console.log('애플리케이션 초기화 완료');
}

// 모달 팝업 관련 함수들
function openApplyModal() {
    console.log('모달 열기 함수 호출됨');
    const modal = document.getElementById('applyModal');
    if (modal) {
        modal.style.display = 'block';
        document.body.style.overflow = 'hidden';
        console.log('모달이 열렸습니다');
    } else {
        console.error('모달 요소를 찾을 수 없습니다');
        alert('모달을 찾을 수 없습니다. 페이지를 새로고침해주세요.');
    }
}

// 간단한 테스트 함수
function testModal() {
    console.log('테스트 모달 함수 호출');
    alert('테스트 모달 함수가 호출되었습니다!');
}

function closeApplyModal() {
    document.getElementById('applyModal').style.display = 'none';
    document.body.style.overflow = 'auto';
    document.getElementById('applyForm').reset();
    document.getElementById('successMessage').style.display = 'none';
}

// 모달 외부 클릭 시 닫기
window.onclick = function(event) {
    const modal = document.getElementById('applyModal');
    if (event.target === modal) {
        closeApplyModal();
    }
}

// 폼 제출 처리
async function handleFormSubmit(e) {
    e.preventDefault();
    console.log('폼 제출 처리 시작');
    
    const name = document.getElementById('name').value.trim();
    const age = document.getElementById('age').value;
    const phone = document.getElementById('phone').value.trim();
    const motivation = document.getElementById('motivation').value.trim();
    
    console.log('입력된 데이터:', { name, age, phone, motivation });
    
    // 유효성 검사
    if (!name || !age || !phone || !motivation) {
        alert('모든 필드를 입력해주세요.');
        return;
    }
    
    if (age < 1 || age > 100) {
        alert('올바른 나이를 입력해주세요.');
        return;
    }

    // 전화번호 형식 검사
    const phoneRegex = /^[0-9-+\s()]+$/;
    if (!phoneRegex.test(phone)) {
        alert('올바른 전화번호를 입력해주세요.');
        return;
    }
    
    try {
        console.log('Firebase 저장 시작');
        
        // 중복 신청 체크 (같은 전화번호로 1시간 내 신청이 있는지 확인)
        const db = getFirebaseDB();
        if (db) {
            const oneHourAgo = new Date(Date.now() - 60 * 60 * 1000);
            try {
                const duplicateCheck = await db.collection('applications')
                    .where('phone', '==', phone)
                    .where('timestamp', '>', oneHourAgo)
                    .get();
                
                if (!duplicateCheck.empty) {
                    alert('이미 신청하신 전화번호입니다. 1시간 후에 다시 시도해주세요.');
                    return;
                }
            } catch (error) {
                console.log('중복 체크 중 오류 (무시하고 진행):', error);
            }
        }
        
        // Firebase에 데이터 저장
        await saveToFirebase({
            name: name,
            age: parseInt(age),
            phone: phone,
            motivation: motivation,
            status: '신청완료'
        });
        
        console.log('Firebase 저장 완료');
        // 성공 메시지 표시
        document.getElementById('successMessage').style.display = 'block';
        
        // 3초 후 모달 닫기
        setTimeout(() => {
            closeApplyModal();
        }, 3000);
        
    } catch (error) {
        console.error('데이터 저장 실패:', error);
        alert('신청 중 오류가 발생했습니다. 다시 시도해주세요.');
    }
}

// Firebase에 데이터 저장
async function saveToFirebase(data) {
    try {
        const db = getFirebaseDB();
        console.log('Firebase DB 객체 확인:', db);
        console.log('Firebase 앱 상태:', firebase.apps);
        
        if (!db) {
            throw new Error('Firebase Firestore가 초기화되지 않았습니다.');
        }
        
        // 데이터를 Firestore에 저장
        const docRef = await db.collection('applications').add({
            ...data,
            timestamp: firebase.firestore.FieldValue.serverTimestamp()
        });
        
        console.log('데이터가 Firebase에 저장되었습니다:', data);
        console.log('저장된 문서 ID:', docRef.id);
        return docRef;
    } catch (error) {
        console.error('Firebase 저장 오류:', error);
        throw error;
    }
}

// 관리자 모드 토글
function toggleAdminMode() {
    console.log('관리자 모드 토글 호출됨');
    
    // 비밀번호 입력 요청
    const password = prompt('관리자 비밀번호를 입력하세요:');
    
    if (password === '1234') {
        isAdminMode = !isAdminMode;
        
        if (isAdminMode) {
            openAdminDashboard();
        } else {
            closeAdminDashboard();
        }
    } else if (password !== null) {
        alert('비밀번호가 올바르지 않습니다.');
    }
}

// 관리자 대시보드 열기
function openAdminDashboard() {
    const dashboard = document.getElementById('adminDashboard');
    dashboard.style.display = 'block';
    loadApplications();
}

// 관리자 대시보드 닫기
function closeAdminDashboard() {
    const dashboard = document.getElementById('adminDashboard');
    dashboard.style.display = 'none';
}

// 신청 데이터 로드
async function loadApplications() {
    try {
        const db = getFirebaseDB();
        console.log('데이터 로드 시작');
        console.log('Firebase DB 객체:', db);
        
        if (!db) {
            throw new Error('Firebase Firestore가 초기화되지 않았습니다.');
        }
        
        const snapshot = await db.collection('applications')
            .orderBy('timestamp', 'desc')
            .get();
        
        console.log('쿼리 결과:', snapshot.size, '개의 문서');
        
        const applications = [];
        snapshot.forEach(doc => {
            const data = doc.data();
            applications.push({
                id: doc.id,
                ...data
            });
        });
        
        console.log('로드된 애플리케이션:', applications);
        displayApplications(applications);
    } catch (error) {
        console.error('데이터 로드 오류:', error);
        alert('데이터를 불러오는 중 오류가 발생했습니다: ' + error.message);
    }
}

// 신청 데이터 표시
function displayApplications(applications) {
    const container = document.getElementById('applicationsContainer');
    
    if (applications.length === 0) {
        container.innerHTML = '<p class="no-data">신청된 데이터가 없습니다.</p>';
        return;
    }
    
    const html = applications.map(app => `
        <div class="application-card">
            <div class="app-header">
                <h3>${app.name} (${app.age}세)</h3>
                <span class="timestamp">${formatDate(app.timestamp)}</span>
            </div>
            <div class="app-details">
                <p><strong>전화번호:</strong> ${app.phone}</p>
                <p><strong>수강신청동기:</strong></p>
                <div class="motivation-text">${app.motivation}</div>
                <p><strong>상태:</strong> <span class="status ${app.status === '신청완료' ? 'pending' : 'completed'}">${app.status}</span></p>
            </div>
            <div class="app-actions">
                <button onclick="updateStatus('${app.id}', '승인완료')" class="btn-approve">승인</button>
                <button onclick="deleteApplication('${app.id}')" class="btn-delete">삭제</button>
            </div>
        </div>
    `).join('');
    
    container.innerHTML = html;
}

// 날짜 포맷팅
function formatDate(timestamp) {
    try {
        if (timestamp && timestamp.toDate) {
            const date = timestamp.toDate();
            return date.toLocaleString('ko-KR');
        } else if (timestamp) {
            const date = new Date(timestamp);
            return date.toLocaleString('ko-KR');
        } else {
            return '날짜 없음';
        }
    } catch (error) {
        console.error('날짜 포맷팅 오류:', error);
        return '날짜 오류';
    }
}

// 상태 업데이트
async function updateStatus(id, status) {
    try {
        const db = getFirebaseDB();
        if (!db) {
            throw new Error('Firebase Firestore가 초기화되지 않았습니다.');
        }
        
        await db.collection('applications').doc(id).update({
            status: status,
            updatedAt: new Date()
        });
        loadApplications(); // 목록 새로고침
    } catch (error) {
        console.error('상태 업데이트 오류:', error);
        alert('상태 업데이트 중 오류가 발생했습니다.');
    }
}

// 신청 삭제
async function deleteApplication(id) {
    if (!confirm('정말로 이 신청을 삭제하시겠습니까?')) {
        return;
    }
    
    try {
        const db = getFirebaseDB();
        if (!db) {
            throw new Error('Firebase Firestore가 초기화되지 않았습니다.');
        }
        
        await db.collection('applications').doc(id).delete();
        loadApplications(); // 목록 새로고침
    } catch (error) {
        console.error('삭제 오류:', error);
        alert('삭제 중 오류가 발생했습니다.');
    }
}

// Firebase 연결 테스트
function testFirebaseConnection() {
    const db = getFirebaseDB();
    if (db) {
        console.log('Firebase 연결 성공!');
        alert('Firebase 연결이 정상입니다.');
    } else {
        console.log('Firebase 연결 실패!');
        alert('Firebase 연결에 실패했습니다.');
    }
}

// 중복 데이터 정리 (관리자용)
async function cleanupDuplicateData() {
    if (!confirm('중복 데이터를 정리하시겠습니까? 이 작업은 되돌릴 수 없습니다.')) {
        return;
    }
    
    try {
        const db = getFirebaseDB();
        if (!db) {
            throw new Error('Firebase Firestore가 초기화되지 않았습니다.');
        }
        
        const snapshot = await db.collection('applications').get();
        const applications = [];
        const duplicates = new Map();
        
        snapshot.forEach(doc => {
            const data = doc.data();
            const key = `${data.phone}-${data.name}`;
            if (duplicates.has(key)) {
                duplicates.get(key).push({ id: doc.id, data: data });
            } else {
                duplicates.set(key, [{ id: doc.id, data: data }]);
            }
        });
        
        let deletedCount = 0;
        for (const [key, docs] of duplicates) {
            if (docs.length > 1) {
                // 가장 최근 것을 제외하고 나머지 삭제
                docs.sort((a, b) => {
                    const aTime = a.data.timestamp && a.data.timestamp.toDate ? a.data.timestamp.toDate() : new Date(0);
                    const bTime = b.data.timestamp && b.data.timestamp.toDate ? b.data.timestamp.toDate() : new Date(0);
                    return bTime - aTime;
                });
                for (let i = 1; i < docs.length; i++) {
                    await db.collection('applications').doc(docs[i].id).delete();
                    deletedCount++;
                }
            }
        }
        
        alert(`${deletedCount}개의 중복 데이터가 정리되었습니다.`);
        loadApplications();
    } catch (error) {
        console.error('중복 데이터 정리 오류:', error);
        alert('중복 데이터 정리 중 오류가 발생했습니다.');
    }
} 