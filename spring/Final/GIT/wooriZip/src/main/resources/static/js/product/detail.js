document.addEventListener("DOMContentLoaded", function () {
    const modelSelect = document.getElementById('modelSelect');
    const countInput = document.getElementById('count');
    const totalPrice = document.getElementById('totalPrice');
    const selectedPriceSpan = document.getElementById('selectedPrice');
    const modelInfo = document.getElementById('modelInfo');
    const allAttributeValues = window.allAttributeValues || [];

    // 가격/수량 계산
    function updatePriceAndTotal() {
        const selected = modelSelect?.selectedOptions[0];
        let price = 0;
        if (selected && selected.dataset.price) {
            price = parseInt(selected.dataset.price);
            selectedPriceSpan && (selectedPriceSpan.innerText = price.toLocaleString());
            modelInfo && (modelInfo.innerText = `가격: ${price}원, 재고: ${selected.dataset.stock}`);
        } else {
            selectedPriceSpan && (selectedPriceSpan.innerText = '0');
            modelInfo && (modelInfo.innerText = '모델/옵션을 선택하세요.');
        }
        const count = parseInt(countInput?.value) || 1;
        totalPrice && (totalPrice.innerText = (price * count).toLocaleString() + '원');
    }

    // 속성값 드롭다운 동적 표시
    function updateAttributeDropdowns() {
        const selected = modelSelect?.selectedOptions[0];
        let attrIds = [];
        if (selected && selected.dataset.attr) {
            try {
                attrIds = JSON.parse(selected.dataset.attr.replaceAll("'", '"'));
            } catch (e) {
                attrIds = selected.dataset.attr.replace(/\[|\]/g, '').split(',').map(s => s.trim()).filter(Boolean);
            }
        }

        const colorSelect = document.getElementById('colorSelect');
        const sizeSelect = document.getElementById('sizeSelect');
        const materialSelect = document.getElementById('materialSelect');
        if (colorSelect) colorSelect.innerHTML = '<option value="">색상 선택</option>';
        if (sizeSelect) sizeSelect.innerHTML = '<option value="">사이즈 선택</option>';
        if (materialSelect) materialSelect.innerHTML = '<option value="">소재 선택</option>';

        allAttributeValues.forEach(val => {
            if (attrIds.includes(val.id.toString())) {
                const option = `<option value="${val.id}">${val.value}</option>`;
                if (val.attributeName === '색상' && colorSelect) colorSelect.innerHTML += option;
                if (val.attributeName === '사이즈' && sizeSelect) sizeSelect.innerHTML += option;
                if (val.attributeName === '소재' && materialSelect) materialSelect.innerHTML += option;
            }
        });
    }

    // modelSelect, count 이벤트 바인딩
    modelSelect?.addEventListener('change', function () {
        updatePriceAndTotal();
        updateAttributeDropdowns();
    });
    countInput?.addEventListener('input', updatePriceAndTotal);
    updatePriceAndTotal();
    updateAttributeDropdowns();

    // 장바구니/구매 폼 전송
    window.submitForm = function (action) {
        const form = document.getElementById('productForm');
        ['items[0].modelId', 'items[0].count'].forEach(name => {
            const old = form.querySelector(`input[name="${name}"]`);
            if (old) old.remove();
        });

        const selectedModelId = modelSelect?.value;
        const count = countInput?.value;
        if (!selectedModelId || !count) {
            alert("옵션과 수량을 선택해주세요.");
            return;
        }

        const modelInput = document.createElement("input");
        modelInput.type = "hidden";
        modelInput.name = "items[0].modelId";
        modelInput.value = selectedModelId;
        form.appendChild(modelInput);

        const countInputHidden = document.createElement("input");
        countInputHidden.type = "hidden";
        countInputHidden.name = "items[0].count";
        countInputHidden.value = count;
        form.appendChild(countInputHidden);

        form.action = action === 'cart' ? "/cart/add" : "/order/now";
        document.getElementById('actionType').value = action;
        form.submit();
    };

    // 탭 전환 로직
    function initializeTabs() {
        function switchTab(targetId) {
            document.querySelectorAll('.tab-button').forEach(b => {
                b.classList.toggle('active', b.getAttribute('data-target') === targetId);
            });
            document.querySelectorAll('.tab-content-section').forEach(section => {
                section.style.display = section.id === targetId ? 'block' : 'none';
            });
        }

        function handleHash() {
            const hash = window.location.hash;
            if (hash.includes('qna-tab')) {
                switchTab('qna-section');

                const pageMatch = hash.match(/page-(\d+)/);
                if (pageMatch) {
                    const pageButton = document.querySelector(`.page-link[data-page="${pageMatch[1]}"]`);
                    pageButton?.click();
                }

                const qnaMatch = hash.match(/qna-(\d+)/);
                if (qnaMatch) {
                    setTimeout(() => {
                        const qnaElement = document.querySelector(`#qna-${qnaMatch[1]}`);
                        qnaElement?.scrollIntoView({ behavior: 'smooth' });
                    }, 500);
                }
            } else {
                switchTab('review-section');
            }
        }

        document.querySelectorAll('.tab-button').forEach(btn => {
            btn.addEventListener('click', function () {
                const target = this.getAttribute('data-target');
                switchTab(target);
                const currentHash = window.location.hash;
                const pageMatch = currentHash.match(/page-(\d+)/);
                const pageInfo = pageMatch ? `,page-${pageMatch[1]}` : '';
                window.location.hash = target === 'qna-section' ? `qna-tab${pageInfo}` : 'review-section';
            });
        });

        window.addEventListener('hashchange', handleHash);
        handleHash();
    }

    initializeTabs();
});

// 빠른 이동 스크롤 함수
function scrollToSection(sectionId) {
    // 플로팅 메뉴 닫기
    closeFloatingNav();
    
    if (sectionId === 'qna-section') {
        // Q&A 탭으로 직접 전환 (기존 함수 사용)
        switchTabDirect('qna-section');
        setTimeout(() => {
            const section = document.getElementById(sectionId);
            if (section) {
                section.scrollIntoView({ 
                    behavior: 'smooth', 
                    block: 'start',
                    inline: 'nearest'
                });
            }
        }, 200);
    } else if (sectionId === 'review-section') {
        // 리뷰 탭으로 직접 전환 (기존 함수 사용)
        switchTabDirect('review-section');
        setTimeout(() => {
            const section = document.getElementById(sectionId);
            if (section) {
                section.scrollIntoView({ 
                    behavior: 'smooth', 
                    block: 'start',
                    inline: 'nearest'
                });
            }
        }, 200);
    } else {
        // 상세정보 등 일반 섹션
        const section = document.getElementById(sectionId);
        if (section) {
            section.scrollIntoView({ 
                behavior: 'smooth', 
                block: 'start',
                inline: 'nearest'
            });
        }
    }
}

// 탭 직접 전환 함수 (기존 initializeTabs의 switchTab 로직 활용)
function switchTabDirect(targetId) {
    // 탭 버튼 활성화 상태 변경
    document.querySelectorAll('.tab-button').forEach(b => {
        b.classList.toggle('active', b.getAttribute('data-target') === targetId);
    });
    // 탭 컨텐츠 표시/숨김
    document.querySelectorAll('.tab-content-section').forEach(section => {
        section.style.display = section.id === targetId ? 'block' : 'none';
    });
}

// 맨 위로 스크롤
function scrollToTop() {
    closeFloatingNav();
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}

// 플로팅 네비게이션 토글
function toggleFloatingNav() {
    const menu = document.getElementById('floatingNavMenu');
    if (menu) {
        menu.classList.toggle('active');
    }
}

// 플로팅 네비게이션 닫기
function closeFloatingNav() {
    const menu = document.getElementById('floatingNavMenu');
    if (menu) {
        menu.classList.remove('active');
    }
}

// 페이지 클릭 시 플로팅 메뉴 닫기
document.addEventListener('click', function(event) {
    const floatingNav = document.getElementById('floatingNav');
    if (floatingNav && !floatingNav.contains(event.target)) {
        closeFloatingNav();
    }
});
