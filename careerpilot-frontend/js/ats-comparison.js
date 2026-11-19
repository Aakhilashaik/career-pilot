async function loadComparison(){

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/ats/compare"
        );

        const scores =
        await response.json();

        let rows = "";

        scores.forEach(item => {

            rows += `

            <tr>

                <td>${item.resumeId}</td>

                <td>

                    <span class="score-badge">

                        ${item.atsScore}

                    </span>

                </td>

            </tr>

            `;
        });

        document.getElementById(
        "comparisonTable"
        ).innerHTML = rows;

    }

    catch(error){

        console.log(error);

        alert(
        "Unable to load ATS Comparison."
        );
    }
}

async function loadBestResume(){

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/ats/best-resume"
        );

        const best =
        await response.json();

        document.getElementById(
        "bestResumeId"
        ).innerHTML =
        best.resumeId;

        document.getElementById(
        "bestResumeScore"
        ).innerHTML =
        best.atsScore;

    }

    catch(error){

        console.log(error);
    }
}

loadComparison();

loadBestResume();