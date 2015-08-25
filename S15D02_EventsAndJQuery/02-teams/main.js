/**
 * Ovaj dokument pokušava objasniti kako event-i funkcionišu u JavaScript-u.
 * Čitajte ovaj kôd imajući na umu nekoliko paralela koje pokušavamo
 * uspostaviti:
 *
 * - `teamA` je objekat koji ima metodu `add` te event `onadd`, te kojem možemo
 *   dodijeliti event handler. `teamA` je dakle paralela DOM objektu koji
 *   predstavlja dugme
 * - `onadd` je  atribut kojem dodjeljujemo event handler, te je paralela
 *   `onclick` atributu dugmeta
 * - `add()` je metoda čiji poziv uzrokuje okidanje eventa te paralela za
 *   klikanje na dugme
 */

var teamA = {
  name: "Team A",
  members: [],
  onadd: null,

  add: function(person) {
    this.members.push(person);

    // event objekat koji će biti proslijeđen `onadd` event handleru
    var event = {
      team: this,
      member: person
    };

    // ako `onadd` event ima handler, onda pozivamo handler. Ako nema,
    // ignorišemo ga da ne bismo dobili `TypeErrror`
    if (this.onadd != null) {
      this.onadd(event);
    }
  }
};

function memberAdded(event) {
  alert(event.member.name + ' was added to team ' + event.team.name);
}

// dodajemo funkciju `memberAdded()` kao event handler za `onadd` event `teamA`
// objekta
teamA.onadd = memberAdded;

var mujo = {
  name: "Mujo",
  email: "mujo@bitcamp.ba"
};

var zulejha = {
  name: "Zulejha",
  email: "zulejha_cwazy99@hotmail.com"
};

// pozivamo `add()` metodu, koja će okinuti (trigger-ovati) naš event handler
teamA.add(mujo);
teamA.add(zulejha);

debugger;
