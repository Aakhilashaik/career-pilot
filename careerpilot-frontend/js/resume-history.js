async function loadResumes(){

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/resumes/user/1"
        );

        const resumes =
        await response.json();

        let rows = "";

        resumes.forEach(resume => {

            rows +=

            `<tr>

                <td>${resume.id}</td>

                <td>${resume.resumeName}</td>

                <td>V${resume.versionNumber}</td>

                <td>${resume.uploadedAt}</td>

            </tr>`;
        });

        document.getElementById(
        "resumeTable"
        ).innerHTML =
        rows;

    }
    catch(error){

        console.log(error);

        alert(
        "Unable to load resumes."
        );
    }
}

loadResumes();