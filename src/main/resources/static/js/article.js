// 삭제 기능
// id를 delete-btn으로 설정한 element를 찾아
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    // 그 element에서 클릭 이벤트가 발생하면
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, { // fetch() 메서드로 /api/articles/에 DELETE 요청을 보내는 역할
            method: 'DELETE'
        })
            // fetch()가 잘 완료되면 연이어 실행되는 메서드
        .then (() => {
            alert('삭제가 완료되었습니다.'); // then()메서드가 실행되는 시점에 웹 브라우저 화면으로 삭제 완료 팝업으 띄우는 메서드
            location.replace('/articles'); // 실행 시 사용자의 웹 브라우저 화면을 현재 주소를 기반해 옮겨주는 역할
        });
    });
}