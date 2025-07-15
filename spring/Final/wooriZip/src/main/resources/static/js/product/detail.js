document.addEventListener("DOMContentLoaded", function () {
    // 가격 계산
    function calculateTotalPrice() {
        var count = parseInt($('#count').val());
        var price = parseInt($('#price').val());
        if (!isNaN(count) && !isNaN(price)) {
            var totalPrice = count * price;
            $('#totalPrice').html(totalPrice + '원');
        } else {
            $('#totalPrice').html('가격 계산 오류');
        }
    }

    calculateTotalPrice();
    $('#count').change(calculateTotalPrice);

    // 모델 선택 이벤트
    const modelSelect = document.getElementById('modelSelect');
    if (modelSelect) {
        modelSelect.addEventListener('change', function () {
            const selected = this.selectedOptions[0];
            if (selected && selected.value) {
                document.getElementById('modelInfo').innerText =
                    `가격: ${selected.dataset.price}원, 재고: ${selected.dataset.stock}`;
            } else {
                document.getElementById('modelInfo').innerText = '';
            }
        });
    }

    // submitForm 정의
    window.submitForm = function (action) {
        const form = document.getElementById('productForm');

        // 기존 items 필드 제거
        ['items[0].modelId', 'items[0].count'].forEach(name => {
            const old = form.querySelector(`input[name="${name}"]`);
            if (old) old.remove();
        });

        // ✅ select 박스에서 modelId 가져오기
        const selectedModelId = document.getElementById('modelSelect')?.value;
        const count = document.getElementById('count').value;

        if (!selectedModelId || !count) {
            alert("옵션과 수량을 선택해주세요.");
            return;
        }

        // 동적 필드 추가
        const modelInput = document.createElement("input");
        modelInput.type = "hidden";
        modelInput.name = "items[0].modelId";
        modelInput.value = selectedModelId;
        form.appendChild(modelInput);

        const countInput = document.createElement("input");
        countInput.type = "hidden";
        countInput.name = "items[0].count";
        countInput.value = count;
        form.appendChild(countInput);

        // 액션 설정
        if (action === 'cart') {
            form.action = "/cart/add";
            document.getElementById('actionType').value = 'cart';
        } else if (action === 'buy') {
            form.action = "/order/now";
            document.getElementById('actionType').value = 'buy';
        }

        form.submit();
    };
});

// 탭 전환 - 모든 탭 전환 로직을 여기로 통합
    function initializeTabs() {
        document.querySelectorAll('.tab-button').forEach(btn => {
            btn.addEventListener('click', function () {
                // 기존 이벤트 리스너 제거
                btn.removeEventListener('click', arguments.callee);

                document.querySelectorAll('.tab-button').forEach(b => b.classList.remove('active'));
                this.classList.add('active');

                const target = this.getAttribute('data-target');
                document.querySelectorAll('.tab-content-section').forEach(section => {
                    section.style.display = section.id === target ? 'block' : 'none';
                });
            });
        });
    }

    // 탭 초기화 실행
    initializeTabs();
