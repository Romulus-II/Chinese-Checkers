var foo = new ActiveXObject("Scripting.FileSystemObject");
var filename = "C:\\Users\\G-star\\Documents\\ChineseCheckers\\Output.txt";

foo.CreateTextFile(filename);
var file = foo.GetFile(filename);

var writer = file.OpenAsTextStream(2);

function collectOutput() {
  var index = 0;
  var rounds = 1;
  writer.write('1) ');
  for(var i = 0; i < moves.length; i++) {
    if(index == num_players) {
      index = 0;
      rounds++;
      var marker = (rounds + ') ');
      writer.writeLine();
      writer.write(marker);
    }
    writer.write(moves[i] + '   ');
  }
}

function publish() {
  collectOutput();
  writer.writeLine();
  writer.close();
}
