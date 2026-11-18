async function scheduleInterview(){

    const interview = {

        userId : 1,

        companyName :
        document.getElementById(
        "companyName"
        ).value,

        roundName :
        document.getElementById(
        "roundName"
        ).value,

        interviewDate :
        document.getElementById(
        "interviewDate"
        ).value,

        interviewTime :
        document.getElementById(
        "interviewTime"
        ).value + ":00",

        meetingLink :
        document.getElementById(
        "meetingLink"
        ).value,

        status : "Scheduled",

        feedback : ""
    };

    const response =
    await fetch(
    "http://localhost:8080/api/interviews",
    {
        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:
        JSON.stringify(interview)
    });

    const result =
    await response.text();

    alert(result);

    loadInterviews();
}

async function loadInterviews(){

    const response =
    await fetch(
    "http://localhost:8080/api/interviews/user/1"
    );

    const interviews =
    await response.json();

    let rows = "";

    interviews.forEach(interview => {

        rows +=

        `<tr>

            <td>${interview.companyName}</td>

            <td>${interview.roundName}</td>

            <td>${interview.interviewDate}</td>

            <td>

              <span class="status-badge">

              ${interview.status}

              </span>

            </td>

        </tr>`;
    });

    document.getElementById(
    "interviewTable"
    ).innerHTML = rows;
}

loadInterviews();