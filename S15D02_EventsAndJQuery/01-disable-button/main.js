function toggleDisabled() {
  if (nameField.value != "" &&
      ageField.value != "") {
    addButton.disabled = false;
  } else {
    addButton.disabled = true;
  }
}

function insertData() {
  var dataTable = document.getElementById('data-table');

  var newRow = document.createElement('tr');
  var nameCell = document.createElement('td');
  var ageCell = document.createElement('td');
  var buttonCell = document.createElement('td');

  nameCell.innerText = nameField.value;
  ageCell.innerText = ageField.value;

  var removeButton = document.createElement('button');
  removeButton.innerText = "Remove";
  removeButton.onclick = removeCurrentRow;
  buttonCell.appendChild(removeButton);

  newRow.appendChild(nameCell);
  newRow.appendChild(ageCell);
  newRow.appendChild(buttonCell);

  dataTable.appendChild(newRow);

  return false;
}

function removeCurrentRow(event) {
  var dataTable = document.getElementById('data-table');

  var button = event.target;
  var buttonCell = button.parentElement;
  var row = buttonCell.parentElement;

  dataTable.removeChild(row);
}

var nameField = document.getElementById('name');
var ageField = document.getElementById('age');
var addButton = document.getElementById('add-button');

nameField.onkeyup = toggleDisabled;
ageField.onkeyup = toggleDisabled;
addButton.onclick = insertData;


