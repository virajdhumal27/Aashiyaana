let preveiwContainer = document.querySelector('.products-preview');
let previewBox = preveiwContainer.querySelectorAll('.preview');
let API_URL = "http://192.168.239.65:9191";
const USER_ID = 'userid';
const USER_NAME = 'username';

isUserLoggedIn();

document.querySelectorAll('.products-container .product').forEach(product => {
  product.onclick = () => {
    preveiwContainer.style.display = 'flex';
    let name = product.getAttribute('data-name');
    previewBox.forEach(preview => {
      let target = preview.getAttribute('data-target');
      if (name == target) {
        preview.classList.add('active');
      }
    });
  };
});

previewBox.forEach(close => {
  close.querySelector('.fa-times').onclick = () => {
    close.classList.remove('active');
    preveiwContainer.style.display = 'none';
  };
});

let loadMoreBtn = document.querySelector('#load-more');
let currentItem = 9;
let plus = 21;
if(kitchenData == true) {
  plus = 6;
}

loadMoreBtn.onclick = () => {
  let boxes = [...document.querySelectorAll('.container .products-container .product')];
  for (var i = currentItem; i < currentItem + plus; i++) {
    boxes[i].style.display = 'inline-block';
  }
  currentItem += 30;

  if (currentItem >= boxes.length) {
    loadMoreBtn.style.display = 'none';
  }
}

async function isUserLoggedIn() {
  // window.localStorage.clear();

  // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
  if(localStorage.length == 0) {
    window.location.replace("../login-signup/login_form.html?#");
  } else {
    let CALL_API = `${API_URL}/rooms/livingrooms/users/${localStorage.getItem("userid")}`
    const response = await fetch(CALL_API);
    const data = await response.json();

    if(!data.isLoggedIn) {
      window.location.replace("../login-signup/login_form.html");
    }
  }
  
  // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
}

async function handleLogoutButton() {
  API_URL = API_URL + '/login/logoutUser';

  const userid = localStorage.getItem(USER_ID);
  const username = localStorage.getItem(USER_NAME);
  const data = { userid, username };
  const options = {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  };
  
  const response = await fetch(API_URL, options);
  const responseData = await response.json();
  if(responseData.isLogoutSuccess) {
    localStorage.removeItem(USER_ID);
    localStorage.removeItem(USER_NAME);
    localStorage.clear();
    window.location.replace("../login-signup/login_form.html?#");
  }
  console.log(responseData);

}