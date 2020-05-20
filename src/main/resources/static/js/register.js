const form = document.getElementById('form');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');
const submitbutton = document.querySelector("#submitbutton");
let password1Confirmation;
let password2Confirmation;
let usernameConfirmation;
let emailConfirmation;

window.onload = "submitButton()";

username.addEventListener('keyup', function () {
    if (username.value.length < 3) {
        setErrorFor(username, 'Username too small');
    } else if (username.value.length > 40) {
        setErrorFor(username, 'Username too big');
    } else if (username.length > 3 || username.value.length < 40) {
        var myusername = $("#username").val();
        $.ajax({
            type: "POST",
            url: "checkusername/" + myusername,
            success: function (result) {
                if (result === "ok") {
                    usernameConfirmation = true;
                    setSuccessFor(username);
                } else {
                    usernameConfirmation = false;
                    setErrorFor(username, 'username exists');
                }
            }});
    }
});

email.addEventListener('keyup', function () {
    if (email.value.length < 6) {
        setErrorFor(email, 'Not a valid email');
    } else if (!isEmail(email.value)) {
        setErrorFor(email, 'Not a valid email');
    } else {
        var myemail = $("#email").val();
        $.ajax({
            type: "POST",
            url: "checkemail/" + myemail,
            success: function (result) {
                if (result === "ok") {
                    emailConfirmation = true;
                    setSuccessFor(email);
                } else {
                    emailConfirmation = false;
                    setErrorFor(email, 'email exists');
                }
            }});
    }
});


password.addEventListener('keyup', function () {
    if (password.value.length < 7) {
        setErrorFor(password, 'weak password');
        password1Confirmation = false;
    } else if (password.value.length > 50) {
        setErrorFor(password, 'password too big');
        password1Confirmation = false;
    } else if (password2Confirmation && password.value.length !== password2.value.length) {
        setErrorFor(password2, 'password mismatch');
    } else {
        setSuccessFor(password);
        password1Confirmation = true;
    }
});

password2.addEventListener("keyup", function () {
    if (password.value.length !== password2.value.length) {
        setErrorFor(password2, 'password mismatch');
        password2Confirmation = false;
    } else if (password.value !== password2.value) {
        setErrorFor(password2, 'password mismatch');
        password2Confirmation = false;
    } else {
        setSuccessFor(password2);
        password2Confirmation = true;
    }
});

document.addEventListener("mousemove", function () {
    if (password1Confirmation && password2Confirmation && usernameConfirmation && emailConfirmation) {
        console.log("password1Confirmation", password1Confirmation);
        console.log("password2Confirmation", password2Confirmation);
        console.log("emailConfirmation", emailConfirmation);
        console.log("usernameConfirmation", usernameConfirmation);
        submitbutton.disabled = false;
    } else {
        submitbutton.disabled = true;
    }
});

document.addEventListener("keyup", function () {
    if (password1Confirmation && password2Confirmation && usernameConfirmation && emailConfirmation) {
        submitbutton.disabled = false;
    } else {
        submitbutton.disabled = true;
    }
});

function submitButton() {
    submitbutton.disabled = true;
    password1Confirmation = false;
    password2Confirmation = false;
    usernameConfirmation = false;
    emailConfirmation = false;
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-control error';
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}
