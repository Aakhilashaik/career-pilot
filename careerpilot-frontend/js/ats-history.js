async function loadHistory(){

    try{

        const response =
        await fetch(
        "http://localhost:8080/api/ats/history"
        );

        const history =
        await response.json();

        let rows = "";

        history.forEach(item => {

            rows += `

            <tr>

                <td>${item.id}</td>

                <td>${item.resumeId}</td>

                <td>

                    <span class="score-badge">

                        ${item.atsScore}

                    </span>

                </td>

                <td>${item.matchedKeywords}</td>

                <td>${item.missingKeywords}</td>

                <td>${item.recruiterFeedback}</td>

            </tr>

            `;
        });

        document.getElementById(
        "historyTable"
        ).innerHTML = rows;

    }

    catch(error){

        console.log(error);

        alert(
        "Unable to load ATS History"
        );
    }
}

loadHistory();