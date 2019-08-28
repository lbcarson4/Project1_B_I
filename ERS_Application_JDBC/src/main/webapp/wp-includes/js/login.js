function animForm() {
    const sign = document.querySelectorAll(".fa-arrow-alt-circle-down");

    sign.forEach(i => {
        i.addEventListener("click", () => {
            const input = i.previousElementSibling;
            const mainForm = i.parentElement;
            const nextForm = mainForm.nextElementSibling;

            if (input.type === "text" && checkUserField(input)) {
                // nextStep(mainForm, nextForm);
            } else if (input.type === "password" && checkUserField(input)) {
                // nextStep(mainForm, nextForm);               
            } else {
                mainForm.style.animation = "shake 0.5s ease";
            }
            mainForm.addEventListener("animationend", () => {
                mainForm.style.animation = "";
            })
        });
    });
}

function checkUserField(user) {
    let urlImg = "url('http://localhost:8080/ERS_Application_JDBC/wp-content/error.png')";
    let urlImg2 = "url('http://localhost:8080/ERS_Application_JDBC/wp-content/spiral_staircase.png')";
    if (user.value.length < 6) {
        error(urlImg);
    } else {
        error(urlImg2);
        return true;
    }
}

function nextStep(mainForm, nextForm) {
    mainForm.classList.add("inactive");
    mainForm.classList.remove("active");
    nextForm.classList.add("active");
}

function error(img) {
    document.body.style.backgroundImage = img;
}
animForm();