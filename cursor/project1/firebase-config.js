// Firebase 설정
// Firebase 콘솔(https://console.firebase.google.com/)에서 프로젝트를 생성하고
// 웹 앱을 추가한 후 아래 정보를 실제 값으로 교체해주세요.

const firebaseConfig = {
    apiKey: "AIzaSyArIykw7EZZwSZWLT8ytfe5AvDF5I5nBvE",
    authDomain: "kgh1-7ade2.firebaseapp.com",
    projectId: "kgh1-7ade2",
    storageBucket: "kgh1-7ade2.firebasestorage.app",
    messagingSenderId: "943118633531",
    appId: "1:943118633531:web:79c606ea66b68c6f0baa1e"
};

// Firebase 초기화
let db;

// Firebase가 로드될 때까지 대기
function initializeFirebase() {
    if (typeof firebase !== 'undefined') {
        try {
            firebase.initializeApp(firebaseConfig);
            db = firebase.firestore();
            console.log('Firebase 초기화 성공');
            console.log('Firestore DB 객체:', db);
        } catch (error) {
            console.error('Firebase 초기화 오류:', error);
        }
    } else {
        console.log('Firebase SDK 로드 대기 중...');
        setTimeout(initializeFirebase, 100);
    }
}

// 초기화 시작
initializeFirebase();

// Firestore 보안 규칙 설정 필요:
// Firebase 콘솔 > Firestore Database > 규칙에서 다음 규칙을 설정하세요:
/*
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /applications/{document} {
      allow read, write: if true;  // 개발용 (실제 운영시에는 인증 추가 필요)
    }
  }
}
*/ 