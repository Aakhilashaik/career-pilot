async function login(){

    const email =
    document.getElementById("email").value;

    const password =
    document.getElementById("password").value;

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/auth/login",
        {
            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body:JSON.stringify({

                email:email,
                password:password
            })
        });

        const result =
        await response.text();

        alert(result);

        if(result.toLowerCase().includes("success")){

            localStorage.setItem(
                "userEmail",
                email
            );

            window.location.href =
            "dashboard.html";
        }

    }
    catch(error){

        alert(
        "Unable to connect to server."
        );
    }
}