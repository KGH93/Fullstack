document.addEventListener("DOMContentLoaded", function () {
    const parentSelect = document.getElementById("parentCategory");
    const middleSelect = document.getElementById("middleCategory");
    const childSelect = document.getElementById("childCategory");
    const input = document.getElementById('imageInput');
    const preview = document.getElementById('previewContainer');
    const form = document.getElementById('productForm');
    const optionContainer = document.getElementById('optionContainer');
    let selectedFiles = [];

    // 1. 카테고리 드롭다운 로딩
    fetch("/categories/parents")
        .then(res => res.json())
        .then(data => {
            data.forEach(c => {
                const option = new Option(c.name, c.id);
                parentSelect.appendChild(option);
            });
        });

    parentSelect?.addEventListener('change', function () {
        const parentId = this.value;
        middleSelect.innerHTML = '<option value="">중분류 선택</option>';
        childSelect.innerHTML = '<option value="">소분류 선택</option>';
        if (!parentId) return;
        fetch(`/categories/children?parentId=${parentId}`)
            .then(res => res.json())
            .then(data => {
                data.forEach(c => {
                    middleSelect.appendChild(new Option(c.name, c.id));
                });
            });
    });

    middleSelect?.addEventListener('change', function () {
        const middleId = this.value;
        childSelect.innerHTML = '<option value="">소분류 선택</option>';
        if (!middleId) return;
        fetch(`/categories/children?parentId=${middleId}`)
            .then(res => res.json())
            .then(data => {
                data.forEach(c => {
                    childSelect.appendChild(new Option(c.name, c.id));
                });
            });
    });

    // 2. 이미지 미리보기
    input.addEventListener('change', function () {
        selectedFiles = Array.from(this.files);
        if (selectedFiles.length > 8) {
            alert("이미지는 최대 8장까지 업로드할 수 있습니다.");
            selectedFiles = selectedFiles.slice(0, 8);
            this.value = '';
            preview.innerHTML = '';
            return;
        }

        preview.innerHTML = '';
        selectedFiles.forEach(file => {
            const reader = new FileReader();
            reader.onload = e => {
                const box = document.createElement('div');
                box.className = 'img-box';

                const img = document.createElement('img');
                img.src = e.target.result;

                const btn = document.createElement('button');
                btn.type = 'button';
                btn.className = 'remove-btn';
                btn.innerText = 'X';
                btn.onclick = () => {
                    const idx = selectedFiles.indexOf(file);
                    if (idx > -1) selectedFiles.splice(idx, 1);
                    box.remove();
                };

                box.appendChild(img);
                box.appendChild(btn);
                preview.appendChild(box);
            };
            reader.readAsDataURL(file);
        });
    });

    // 3. 모델/옵션 추가
    addModelBtn.addEventListener('click', function () {
        fetch('/products/attributes')
            .then(res => res.json())
            .then(attributes => {
                const item = createModelItem(attributes);
                modelList.appendChild(item);
                updateRemoveButtons();
            });
    });

    function createModelItem(attributes) {
        const item = document.createElement('div');
        item.className = 'model-item';

        let html = `
            <h4>모델/옵션 ${modelList.children.length + 1}</h4>
            <input type="text" placeholder="모델명/옵션명" name="productModelDtoList[${modelList.children.length}].productModelSelect" required>
            <input type="number" placeholder="재고" name="productModelDtoList[${modelList.children.length}].prStock" required>
            <input type="number" placeholder="가격" name="productModelDtoList[${modelList.children.length}].price" required>
            <button type="button" class="remove-model-btn">모델 삭제</button>
            <div class="attributes">
        `;

        Object.entries(attributes).forEach(([attrName, values]) => {
            html += `<div class="attr-group">
                <strong>${attrName}:</strong>`;
            values.forEach(val => {
                html += `<label><input type="checkbox" name="productModelDtoList[${modelList.children.length}].attributeValueIds" value="${val.id}"> ${val.value}</label>`;
            });
            html += `</div>`;
        });

        html += `</div>`;
        item.innerHTML = html;

        item.querySelector('.remove-model-btn').addEventListener('click', function () {
            item.remove();
            updateIndexes();
            updateRemoveButtons();
        });

        return item;
    }

    function updateRemoveButtons() {
        const removeButtons = document.querySelectorAll('.remove-model-btn');
        removeButtons.forEach(btn => {
            btn.style.display = modelList.children.length > 1 ? 'inline-block' : 'none';
        });
    }

    function updateIndexes() {
        const items = Array.from(modelList.children);
        items.forEach((item, idx) => {
            item.querySelector('input[name$=".productModelSelect"]').name = `productModelDtoList[${idx}].productModelSelect`;
            item.querySelector('input[name$=".prStock"]').name = `productModelDtoList[${idx}].prStock`;
            item.querySelector('input[name$=".price"]').name = `productModelDtoList[${idx}].price`;

            const checkboxes = item.querySelectorAll('input[type="checkbox"]');
            checkboxes.forEach(cb => {
                cb.name = `productModelDtoList[${idx}].attributeValueIds`;
            });
        });
    }

    updateRemoveButtons(); // 초기화
});