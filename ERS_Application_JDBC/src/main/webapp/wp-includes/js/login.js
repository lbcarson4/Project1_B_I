function animForm() {
    const endSign = document.querySelectorAll(".fa-arrow-alt-circle-down, .fa-check-circle");

    endSign.forEach(sign => {
        sign.addEventListener("click", () => {
            const input = sign.previousElementSibling;
            const mainForm = sign.parentElement;
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
    let urlImg = "url('/ERS_Application_JDBC/src/main/webapp/wp-content/error.png')";
    let urlImg2 = "url('http://localhost:8080/ERS_Application_JDBC/wp-content/spiral_staircase.png')";
    if (user.value.length < 1) {
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