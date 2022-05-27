let preveiwContainer = document.querySelector('.products-preview');
let previewBox = preveiwContainer.querySelectorAll('.preview');

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

let loadMoreBtn = document.querySelector('#load-more');
let currentItem = 9;

loadMoreBtn.onclick = () => {
  let boxes = [...document.querySelectorAll('.container .products-container .product')];
  for (var i = currentItem; i < currentItem + 30; i++) {
    boxes[i].style.display = 'inline-block';
  }
  currentItem += 30;

  if (currentItem >= boxes.length) {
    loadMoreBtn.style.display = 'none';
  }
}