def text='''伊豆の伊東にヒロポン屋というものが存在している。旅館の番頭にさそわれてヤキトリ屋へ一パイのみに行って、元ダンサーという女中を相手にのんでいると、まッ黒いフロシキ包み（一尺四方ぐらい）を背負ってはいってきた二十五六の青年がある。女中がついと立って何か話していたが、二人でトントン二階へあがっていった。
　三分ぐらいで降りて戻ってきたが、男が立ち去ると、
「あの人、ヒロポン売る人よ。一箱百円よ。原価六十何円かだから、そんなに高くないでしょ」
　という。東京では、百二十円から、百四十円だそうである。
　ヒロポン屋は遊楽街を御用聞きにまわっているのである。最も濫用しているのはダンサーだそうで、皮下では利きがわるいから、静脈へ打つのだそうだ。
「いま、うってきたのよ」
　と云って、女中は左腕をだして静脈をみせた。五六本、アトがある。中毒というほどではない。ダンサー時代はよく打ったが、今は打たなくともいられる、睡気ざましじゃなくて、打ったトタンに気持がよいから打つのだと言っていた。
　この女中は、自分で静脈へうつのだそうだ。
「たいがい、そうよ。ヒロポンの静脈注射ぐらい、一人でやるのが普通よ。かえって看護婦あがりの人なんかがダメね。人にやってもらってるわ」
　そうかも知れない。看護婦ともなればブドウ糖の注射でも注意を集中してやるものだ。ウカツに静脈注射など打つ気持にはなれないかも知れない。
　織田作之助はヒロポン注射が得意で、酒席で、にわかに腕をまくりあげてヒロポンをうつ。当時の流行の尖端だから、ひとつは見栄だろう。今のように猫もシャクシもやるようになっては、彼もやる気がしなかったかも知れぬ。
　織田はヒロポンの注射をうつと、ビタミンＢをうち、救心をのんでいた。今でもこの風俗は同じことで、ヒロポン・ビタミン・救心。妙な信仰だ。しかし、今の中毒患者はヒロポン代で精一パイだから、信仰は残っているが、めったに実行はされない。
 '''
text =""
InputStreamReader sourcefile = new InputStreamReader(new FileInputStream("corpus/ango1.txt"),"UTF-8");
while ( (line = sourcefile.readLine()  )  != null ){

   if (line != null){
       text=text+"\n"+line
   }
}
println text

 def frequency=[:]
 
 /*
 
 Phase 1:
 Insert a space after all characters that indicate a word (or morpheme) boundary
 
 */
 
 
 /* Segment on punctuation */
 def preprocessedtext=text.replaceAll(/[(;|,|\n)。、?!「」]/," ")
 def hiragana = "ぁ-ゖ"
 def katakana = "゛-ヿ"
 /* Segment on two characters (that are not hiragana or katakana) followed by suffixes */
 preprocessedtext=preprocessedtext.replaceAll(/[^ぁ-ゖ゛-ヿ][^ぁ-ゖ゛-ヿ][のはが]/,/$0 /)
 /* segment on accusative marker */
 preprocessedtext=preprocessedtext.replaceAll(/を/,/$0 /)
/* segment on locative followed by a chinese character */
 preprocessedtext=preprocessedtext.replaceAll(/[にへで][^ぁ-ゖ゛-ヿ]/,/$0 /)

 
 
 /*
 
 Phase 2:
 Tokenize on white space, just as we would do in English
 
 */
 
 def preprocessedsplit=preprocessedtext.split()
 
for(word in preprocessedsplit){ 
  println "this is a word"+word


} 