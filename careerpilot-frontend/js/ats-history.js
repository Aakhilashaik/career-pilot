async function loadHistory(){

    try{
        const response = await fetch("http://localhost:8080/api/ats/history");
        if(!response.ok){
            throw new Error("Unable to load ATS History.");
        }

        const history = await response.json();
        const table = document.getElementById("historyTable");
        table.replaceChildren();

        history.forEach(item => {
            const row = table.insertRow();
            row.insertCell().textContent = item.id;
            row.insertCell().textContent = item.resumeName || `Resume ${item.resumeId}`;

            const scoreCell = row.insertCell();
            const score = document.createElement("span");
            score.className = "score-badge";
            score.textContent = `${item.atsScore}%`;
            scoreCell.appendChild(score);

            row.insertCell().textContent =
                item.recruiterFeedback || "No feedback available.";
        });

        if(history.length === 0){
            const row = table.insertRow();
            const cell = row.insertCell();
            cell.colSpan = 4;
            cell.textContent = "No ATS analyses yet.";
        }

    }
    catch(error){

        console.log(error);
        document.getElementById("historyTable").textContent =
            "Unable to load ATS History.";
    }
}

loadHistory();