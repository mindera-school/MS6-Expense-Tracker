let username = document.getElementById("username-reg");
let password = document.getElementById("password-reg");
let email = document.getElementById("email-reg");

const btnRegister = document.getElementById("register");

function register() {
  if (username.value === "" || password.value === "" || email.value === "") {
    alert("Please enter");
  }
  sendJSONRegister(username.value, password.value, email.value);
}

async function sendJSONRegister(username, password, email) {
  const object = { username, password, email };
  const jsonObject = JSON.stringify(object);
  console.log(jsonObject);
  const response = await fetch("http://localhost:8080/user", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: jsonObject,
  });

  const data = await response.text();
  console.log(data);
}

const btnLogin = document.getElementById("login");
function login(user, password) {
    sendJSONLogin(user.value, password.value);
}
async function sendJSONLogin(user, password) {
    const object = { user, password };
    const jsonObject = JSON.stringify(object);
    console.log(jsonObject);
    const response = await fetch("http://localhost:8080/user", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: jsonObject,
    });

    const data = await response.text();
    console.log(data);
}