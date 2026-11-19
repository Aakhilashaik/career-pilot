async function loadDashboard() {

    try {

        const userId = 1;

        const response =
        await fetch(
            `http://localhost:8080/api/dashboard/user/${userId}`
        );

        const data =
        await response.json();

        document.getElementById(
            "applications"
        ).innerHTML =
        data.totalApplications;

        document.getElementById(
            "interviews"
        ).innerHTML =
        data.totalInterviews;

        document.getElementById(
            "selected"
        ).innerHTML =
        data.selectedApplications;

        document.getElementById(
            "atsScore"
        ).innerHTML =
        data.averageAtsScore + "%";

        const atsCircle =
        document.getElementById(
            "atsCircle"
        );

        if (atsCircle) {

            atsCircle.innerHTML =
                data.averageAtsScore + "%";

            atsCircle.style.background =
                `conic-gradient(
                    #06B6D4 ${data.averageAtsScore}%,
                    #334155 ${100 - data.averageAtsScore}%
                )`;
        }

        const email =
        localStorage.getItem(
            "userEmail"
        );

        const welcomeUser =
        document.getElementById(
            "welcomeUser"
        );

        if (welcomeUser) {

            welcomeUser.innerHTML =
                `
                <h3>
                    Welcome Back 👋
                </h3>

                <p>
                    ${email || "CareerPilot User"}
                </p>

                <small>
                    Career Growth Starts Here
                </small>
                `;
        }

    }
    catch (error) {

        console.log(error);

        alert(
            "Unable to load dashboard."
        );
    }
}

loadDashboard();