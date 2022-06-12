const sign_in = document.getElementById("sign-in");
const sign_out = document.getElementById("sign-out");
const USER_ID = 'userid';
const USER_NAME = 'username';

isUserLoggedIn();
showUsername();
function isUserLoggedIn() {
    // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
    if(localStorage.length == 0) {
      sign_in.classList.remove("d-none")
      sign_out.classList.add("d-none")
    } else {
        sign_out.classList.remove("d-none")
        sign_in.classList.add("d-none")
    }
}

function showUsername() {
  document.getElementById("user-name").innerHTML = localStorage.getItem(USER_NAME);
}

async function handleLogoutButton() {
    const API_URL = 'http://localhost:9191/login/logoutUser';
  
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