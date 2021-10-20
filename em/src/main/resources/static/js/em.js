$('.mail-choice').change(function() {
    if($(this).is(":checked")) {
        $(this).parent().addClass('selected-bg');
  } else {
    $(this).parent().removeClass('selected-bg');
  }
});

const colorInput = document.getElementById("colorpicker");

// colorInput.addEventListener("input", (e) => {
//  document.body.style.setProperty("--button-color", e.target.value);
// });

$('.inbox-calendar').click(function(){
  $('.calendar-container').toggleClass('calendar-show');
 $('.inbox-container').toggleClass('hide');
 $('.mail-detail').toggleClass('hide'); 
});


/* textArea */

function setHandlers () {
  const sections = document.querySelectorAll('section')

  sections.forEach(section => {
    const element = section.firstElementChild
    const clone = element.nextElementSibling
    const next = section.nextElementSibling
      ? section.nextElementSibling.firstElementChild
      : null
    const previous = section.previousElementSibling
      ? section.previousElementSibling.firstElementChild
      : null
    
    element.oninput = event => resizeTextarea(element, clone)
    element.onkeydown = event => executeShortcut(event, element, next, previous)
  })
  
  window.onresize = event => resizeSections(sections)
}

function resizeSections (sections) {
  sections.forEach(section => {
    const element = section.firstElementChild
    const clone = element.nextElementSibling
    
    resizeTextarea(element, clone)
  })
}

function resizeTextarea (element, clone) {
  let value = element.value

  // force the rendering of blank lines by adding a &nbsp;
  if (value.slice(-1) === '\n') value += '\xa0'

  clone.textContent = value
  element.style.height = clone.offsetHeight + 'px'
}

function executeShortcut (event, element, next, previous) {
  switch (event.key) {
    case 'ArrowUp':
      if (!event.repeat) {
        const start = element.selectionStart
        const end = element.selectionEnd
        
        // moves across elements when pressing up at the first index
        if (previous && start === 0 && start === end) {
          event.preventDefault()
          previous.focus()
        }
      }
 
      break

    case 'ArrowDown':
      if (!event.repeat) {
        const start = element.selectionStart
        const end = element.selectionEnd
        
        // moves across elements when pressing down at the last index
        if (next && start === element.value.length && start === end) {
          event.preventDefault()
          next.focus()
        }
      }
      
      break
  }
}

setHandlers()
resizeSections(document.querySelectorAll('section'))
