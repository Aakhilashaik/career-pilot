document
.getElementById("resumeFile")
.addEventListener(
"change",
function(){

    if(this.files.length > 0){

        document.getElementById(
        "selectedFile"
        ).innerHTML =

        "Selected File : "
        + this.files[0].name;
    }
});

async function analyzeResume(){

    try{

        const file =
        document.getElementById(
        "resumeFile"
        ).files[0];

        const jobDescription =
        document.getElementById(
        "jobDescription"
        ).value;

        if(!file){

            alert(
            "Please select a PDF resume."
            );

            return;
        }

        const formData =
        new FormData();

        formData.append(
            "resume",
            file
        );

        formData.append(
            "jobDescription",
            jobDescription
        );

        const response =
        await fetch(
        "http://localhost:8080/api/ats/upload",
        {

            method:"POST",

            body:formData
        });

        const result =
        await response.json();

        document.getElementById(
        "atsScore"
        ).innerHTML =
        result.atsScore + "%";

        document.getElementById(
        "predictedScore"
        ).innerHTML =
        result.predictedScore + "%";

        document.getElementById(
        "skillMatch"
        ).innerHTML =
        result.skillMatchPercentage + "%";

        document.getElementById(
        "projectScore"
        ).innerHTML =
        result.projectScore;

        document.getElementById(
        "experienceScore"
        ).innerHTML =
        result.experienceScore;

        document.getElementById(
        "achievementScore"
        ).innerHTML =
        result.achievementScore;

        document.getElementById(
        "resumeQualityScore"
        ).innerHTML =
        result.resumeQualityScore;

        document.getElementById(
        "matchedKeywords"
        ).innerHTML =
        result.matchedKeywords;

        document.getElementById(
        "missingKeywords"
        ).innerHTML =
        result.missingKeywords;

        document.getElementById(
        "strengths"
        ).innerHTML =
        result.strengths;

        document.getElementById(
        "weaknesses"
        ).innerHTML =
        result.weaknesses;

        document.getElementById(
        "recommendations"
        ).innerHTML =
        result.recommendations;

        document.getElementById(
        "feedback"
        ).innerHTML =
        result.recruiterFeedback;

    }
    catch(error){

        console.log(error);

        alert(
        "Resume analysis failed."
        );
    }
}