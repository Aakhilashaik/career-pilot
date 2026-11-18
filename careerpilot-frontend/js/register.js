async function registerUser(){

    const name =
    document.getElementById("name").value;

    const email =
    document.getElementById("email").value;

    const password =
    document.getElementById("password").value;

    if(
        name === "" ||
        email === "" ||
        password === ""
    ){

        alert("Please fill all fields");

        return;
    }

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/auth/register",
        {

            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body:JSON.stringify({

                fullName:name,
                email:email,
                password:password

            })

        });

        const result =
        await response.text();

        alert(result);

        if(result.toLowerCase().includes("success")){

            window.location.href =
            "login.html";
        }

    }
    catch(error){

        alert(
        "Unable to connect to server."
        );
    }
}