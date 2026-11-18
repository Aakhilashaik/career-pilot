async function analyzeResume(){

    const resumeFile =
    document.getElementById("resumeFile").files[0];
    const jobDescription =
    document.getElementById("jobDescription").value;
    const status =
    document.getElementById("analysisStatus");

    if(!resumeFile){
        status.textContent = "Select a PDF resume before analyzing.";
        return;
    }

    const formData = new FormData();
    formData.append("resume", resumeFile);
    formData.append("jobDescription", jobDescription);
    formData.append("userId", localStorage.getItem("userId") || "1");
    status.textContent = "Analyzing resume...";

    try{
        const response = await fetch(
            "http://localhost:8080/api/ats/analyze-pdf",
            {
                method:"POST",
                body:formData
            }
        );

        if(!response.ok){
            const message = await response.text();
            throw new Error(message || "Unable to analyze this resume.");
        }

        const result = await response.json();
        document.getElementById("atsScore").textContent =
            result.atsScore + "%";
        document.getElementById("predictedScore").textContent =
            result.predictedScore + "%";
        document.getElementById("skillMatch").textContent =
            result.skillMatchPercentage + "%";
        document.getElementById("strengths").textContent =
            result.strengths || "None identified.";
        document.getElementById("weaknesses").textContent =
            result.weaknesses || "None identified.";
        document.getElementById("recommendations").textContent =
            result.recommendations || "No recommendations.";
        status.textContent = "Analysis complete. It has been saved to ATS History.";
    }
    catch(error){
        status.textContent = error.message || "Unable to analyze this resume.";
    }
}
