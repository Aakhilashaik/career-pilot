function logout() {

    localStorage.clear();

    alert(
        "Logged Out Successfully"
    );

    window.location.href =
        "login.html";
}