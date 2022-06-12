let preveiwContainer = document.querySelector('.products-preview');
let previewBox = preveiwContainer.querySelectorAll('.preview');

const sign_in = document.getElementById("sign-in");
const sign_out = document.getElementById("sign-out");
const USER_ID = 'userid';
const USER_NAME = 'username';

isUserLoggedIn();

document.querySelectorAll('.products-container .product').forEach(product => {
  product.onclick = () => {
    preveiwContainer.style.display = 'flex';
    let name = product.getAttribute('data-name');
    previewBox.forEach(preview => {
      let target = preview.getAttribute('data-target');
      if (name == target) {
        preview.classList.add('active');
      }
    });
  };
});

previewBox.forEach(close => {
  close.querySelector('.fa-times').onclick = () => {
    close.classList.remove('active');
    preveiwContainer.style.display = 'none';
  };
});


function isUserLoggedIn() {
    // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
    if(localStorage.length == 0) {
      sign_in.classList.remove("d-none")
      sign_out.classList.add("d-none")
    } else {
        sign_out.classList.remove("d-none")
        sign_in.classList.add("d-none")
    }
}