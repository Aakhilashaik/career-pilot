async function addApplication(){

    const application = {

        userId : 1,

        companyName :
        document.getElementById(
        "companyName"
        ).value,

        jobRole :
        document.getElementById(
        "jobRole"
        ).value,

        location :
        document.getElementById(
        "location"
        ).value,

        packageOffered :
        document.getElementById(
        "packageOffered"
        ).value,

        applicationUrl : "N/A",

        appliedDate :
        new Date()
        .toISOString()
        .split("T")[0],

        status : "Applied"
    };

    const response =
    await fetch(
    "http://localhost:8080/api/applications",
    {
        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(
        application)
    });

    alert(
    await response.text()
    );

    loadApplications();
}

async function loadApplications(){

    const response =
    await fetch(
    "http://localhost:8080/api/applications/user/1"
    );

    const applications =
    await response.json();

    let rows = "";

    applications.forEach(app => {

        rows +=

        `<tr>

            <td>${app.companyName}</td>

            <td>${app.jobRole}</td>

            <td>

              <span class="status-badge">

              ${app.status}

              </span>

            </td>

        </tr>`;
    });

    document.getElementById(
    "applicationTable"
    ).innerHTML = rows;
}

loadApplications();