const tabs = document.querySelectorAll('.tab_menu li'); //탭버튼
const tabList = document.querySelectorAll('#tabContent > div');  //탭내용

tabs.forEach(function (tab, i) {
    tab.addEventListener('click', function (e) {
        e.preventDefault();  //링크금지

        // .tab_menu li 모든 li .active삭제
        tabs.forEach(function (item) {
            item.classList.remove('active');
        });

        tabs[i].classList.add('active');
    });

    tabList.forEach(function (item) {
        item.classList.remove('on');
    });

    tabList[i].classList.add('on');
});
