let modal = document.getElementById("modal");
let openModal = document.getElementById("register-menu");
let closeModal = document.getElementById("close");

openModal.addEventListener("click", () => {
  modal.style.display = "block";
});

closeModal.addEventListener("click", () => {
  modal.style.display = "none";
});

window.onclick = function(event){
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
