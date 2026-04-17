<div id="toast" style="display:none; position:fixed; top:20px; right:20px; background:green; color:white; padding:10px; border-radius:5px;">
    ${msg}
</div>

<script>
    let msg = "${msg}";
    if(msg !== ""){
        let toast = document.getElementById("toast");
        toast.style.display = "block";

        setTimeout(()=>{
            toast.style.display = "none";
        }, 3000);
    }
</script>