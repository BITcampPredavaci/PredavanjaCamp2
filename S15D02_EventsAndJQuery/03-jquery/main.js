function toggleButton() {
  if ($('#name').val() != "" && $("#age").val() != "") {
    $("#add-button").prop('disabled', false);
  } else {
    $("#add-button").prop('disabled', true);
  }
}

function removeCurrentRow(event) {
  $(event.target).closest("tr").remove();
}

/**
 * `insertData()` funkcija napisana koristeći uvezivanje metoda koje jQuery
 * omogućava. Čitava funkcija je, tehnički, jedna naredba.
 */
function insertData() {
  // kreiramo red
  $('<tr>')
    // u red dodajemo ćelije čitji tekst je inicijaliziran vrijednošću u
    // adekvatnom polju
    .append($('<td>', { text: $('#name').val() }))
    // metoda `append()` vraća objekat nad kojim je bila pozvana (u ovom
    // slučaju je to ranije napravljeni <tr>), tako da možemo ponovo pozvati
    // metodu `append()` s drugim argumentima.
    .append($('<td>', { text: $('#age').val() }))
    .append(
      // redu dodajemo <td> kojem dodajemo dugme koje ima event handler za
      // 'click' event
      $('<td>').append(
        $('<button>', { text: "Remove" })
          .on('click', removeCurrentRow)
      )
    )
    // `appendTo()` dodaje objekat čija je metoda pozvana nekom drugom jQuery
    // objektu (u ovom slučaju, dodaje red tabeli)
    .appendTo('#data-table');

  return false;
}

/**
 * `insertData()` funkcija napisana koristeći jQuery ali jako slično tome kako
 * bismo je implementirali bez da koristimo jQuery (ova funkcija se trenutno
 * nigdje ne poziva, promijenite joj ime u `insertData() ako je želite
 * testirati).
 */
function insertData_multipleStatements() {
  var newRow = $('<tr>');

  var nameCell = $('<td>', { text: $('#name').val() });
  var ageCell = $('<td>').text($('#age').val());
  var buttonCell = $('<td>');

  var button = $('<button>', {text: "Remove"});
  button.on('click', removeCurrentRow);
  buttonCell.append(button);

  newRow.append(nameCell);
  newRow.append(ageCell);
  newRow.append(buttonCell);

  $('#data-table').append(newRow);

  return false;
}

// Dodjeljujemo isti event handler (`toggleButton`) za event 'keyup' elementima
// s ID-evima 'name' i 'age'
$("#name, #age").on("keyup", toggleButton);

// Dodjeljujemo event handler za 'click' event dugmetu
$("#add-button").on("click", insertData);
