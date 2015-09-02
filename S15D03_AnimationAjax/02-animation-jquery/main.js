$('.text-container').on('click', function() {
  if ($(this).height() == 550) {
    // za animaciju kroz jQuery možemo koristiti gotove efekte poput
    // `slideUp()`
    $(this).slideUp('slow');

    // ili koristiti metodu `animate` te po želji animirati promjenu više
    // parametara odjednom:
    //
    // $(this).animate(
    //   {
    //     height: '100px',
    //     opacity: 0.5
    //   },
    //   500);
  } else {
    $(this).animate(
      {
        height: '550px',
        opacity: 1
      },
      500);
  }
});
