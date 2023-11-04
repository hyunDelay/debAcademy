
// 상품 선택
const selColor = document.querySelector('#itemColor'); // 컬러 선택
const selSize = document.querySelector('#itemSize'); // 사이즈 선택
const resultLi = document.querySelector('.selectResult'); // 아이템 li
const priceTxt = document.querySelector('.priceText'); // 가격
const totalEl = document.querySelector('.total'); // 총 가격

let colorSelected = false;
let sizeSelected = false;

// 컬러 선택
selColor.addEventListener('change', function() {
    colorSelected = true;
    updateResult();
});

// 사이즈 선택
selSize.addEventListener('change', function() {
    sizeSelected = true;
    updateResult();
});

// 상품 추가
function updateResult() {
    if (colorSelected && sizeSelected) {
        const selColorVal = selColor.options[selColor.selectedIndex].innerText;
        const selSizeVal = selSize.options[selSize.selectedIndex].innerText;
    
        // li 생성
        const newItem = document.createElement('li');
        newItem.innerHTML = `
            <span class="option">${selColorVal}/${selSizeVal}</span>
            <div class="right">
                <input type="number" min="1" value="1">
                <div class="price">
                    <span>${priceTxt.innerText}</span>
                    <em>(적립금 300원)</em>
                </div>
                <button class='deleteBtn'>삭제</button>
            </div>
        `;
        
        // 결과 표시
        resultLi.appendChild(newItem);

        // 초기화
        selColor.value = 'default';
        selSize.value = 'default';

        // 선택 상태 초기화
        colorSelected = false;
        sizeSelected = false;

        // 삭제 이벤트
        const deletebtn = resultLi.querySelectorAll('.deleteBtn');
        for(let i = 0; i < deletebtn.length; i++){
            deletebtn[i].addEventListener('click', deleteItem);
        }

        // 상품 수량 증감
        const itemNum = document.querySelectorAll('.right input[type=number]');

        for(let i = 0; i < itemNum.length; i++){
            itemNum[i].addEventListener('change', (e) => {
                const itemPrice = e.target.parentNode.querySelector('span');
                const numericValue = parseFloat(priceTxt.innerText.replace(/[^0-9]/g, ''));
    
                // 상품 가격
                const resultPrice = numericValue * itemNum[i].value;
                itemPrice.innerHTML = resultPrice.toLocaleString() + ' 원';

                // 총 가격 업데이트
                updateTotalPrice();
            });
        }

        // 총 가격 업데이트
        updateTotalPrice();
        
    }
    
}

// 상품 삭제
function deleteItem(e) {
    e.target.parentNode.parentNode.remove();
    updateTotalPrice();
}

// 총 가격 계산
function updateTotalPrice() {
    const itemPrices = document.querySelectorAll('.right span');
    let total = 0;

    itemPrices.forEach(itemPrice => {
        const numericPrice = parseFloat(itemPrice.innerText.replace(/[^0-9]/g, ''));
        total += numericPrice;
    });

    totalEl.innerText = total.toLocaleString() + ' 원';
}