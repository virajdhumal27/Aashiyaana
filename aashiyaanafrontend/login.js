const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".full-container");
const USER_ID = 'userid';
const USER_NAME = 'username';

sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});

async function handleLoginButton() {
    const API_URL = 'http://localhost:9191/login/loginUser';

    const username = document.getElementById("txtLoginUsername").value;
    const password = document.getElementById("txtLoginPassword").value;

    if (checkLoginValidation(username, password)) {
        const data = { username, password };
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

        console.log(responseData);

        if (responseData.isLoginSuccess) {

            localStorage.setItem(USER_ID, responseData.activeUserId);
            localStorage.setItem(USER_NAME, username);

            console.log("Login Success");
            window.location.replace("./templates/livingRoom.html");
        }
    } else {
        console.log("Login failed");
    }
}

async function handleSignupButton() {

    const API_URL = 'http://localhost:9191/login/signupUser';

    const username = document.getElementById("txtSignupUsername").value;
    const email = document.getElementById("txtSignupEmail").value;
    const phoneNumber = document.getElementById("txtPhoneNumber").value;
    const password = document.getElementById("txtSignupPassword").value;
    const confirmPassword = document.getElementById("txtSignupConfirmPassword").value;

    console.log(username, email, phoneNumber, password, confirmPassword);

    if (checkSignupValidations(username, email, password, confirmPassword)) {
        const data = { username, password, email, phoneNumber };
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

        console.log(responseData);

        if (responseData.isSignedIn) {
            alert("You are now signed in! Redirecting to Login Page...");
            window.location.replace("http://127.0.0.1:5500/login-form.html");
        } else {
            console.log("Sign up failed");
        }
    } else {
        console.log("Validation Failed!");
    }
}

function checkLoginValidation(username, password) {

    if (!isUsernameValid(username)) {
        return false;
    }

    if (!isPasswordValid(password)) {
        return false;
    }

    return true;
}

function checkSignupValidations(username, email, passsword, confirmPassword) {
    if (!isUsernameValid(username)) {
        return false;
    }

    if (passsword != confirmPassword) {
        console.log("Password not matched!");
        return false;
    }

    if (!isPasswordValid(passsword)) {
        return false;
    }

    if (!isEmailValid(email)) {
        return false;
    }

    return true;

}

function isUsernameValid(username) {
    const len = username.length;
    console.log(username.charCodeAt(0));
    let i = 0;

    while (i != len) {
        if (!isCharacterValid(username.charCodeAt(i))) {

            console.log("INVALID, " + username.charAt(i));
            return false;
        }

        i++;
    }
    console.log("VALID");
    return true;
}

function isCharacterValid(char) {
    if ((char >= 65 && char <= 90)
        || (char >= 97 && char <= 122)
        || (char == 95) || (char >= 48 && char <= 57)) {
        return true;
    }

    return false;
}

function isPasswordValid(password) {
    const n = password.length;
    if (n < 6) {
        console.log("n less than 6");
        return false;
    }
    let i = 0;
    let isUpperCase = false;
    let isLowerCase = false;
    let isNumber = false;
    let isSpecial = false;

    const pattern = /[\s~`!@#$%\^&*+=\-\[\];,/{}|:<>\?()\._]/;

    // Check for special character
    if (pattern.test(password)) {
        isSpecial = true;
        console.log("Pattern Passed!");
    } else {
        console.log("Pattern Failed!");
    }

    while (i != n) {
        const char = password.charAt(i);
        // Check for Upper case
        if (char == char.toUpperCase()) {
            console.log("UpperCase Passed!");
            isUpperCase = true;
        }

        // Check for Lower case
        if (char == char.toLowerCase()) {
            console.log("LowerCase Passed!");
            isLowerCase = true;
        }

        // Check for number
        if (!isNaN(char)) {
            console.log("Is a number Passed!");
            isNumber = true;
        }

        // If everything's correct then no need to check further.
        if (isUpperCase && isLowerCase && isNumber && isSpecial) {
            console.log("All Passed!");
            return true;
        }

        i++;
    }
    return false;
}

function isEmailValid(email) {
    if ((email.search("@gmail.com") != -1) || (email.search("@yahoo.com") != -1)) {
        console.log("Email Accepted");
        return true;
    }
    return false;
}
