require 'csv'

intencoes_bob =<<-EOF
ir-ate-biblioteca,
ir-ate-secretaria,
ir-ate-cordenacao,
ir-ate-sala-professores,
ir-ate-sala-estagio
EOF

palavras_chaves_bob = <<-EOF
biblioteca,
secretaria,
cordenação,
sala dos professores,
sala de estágio
EOF


perguntas_intencoes_bob=<<-EOF
Como eu chego a/ao KEYWORK,
pode me levar até KEYWORK,
qual o caminho para a KEYWORK,
Pode me guiar a/ao KEYWORK,
Pode me conduzir a/ao KEYWORK,
Pode me levar até a/ao KEYWORK,
Como eu vou há KEYWORK,
Como eu vou pra KEYWORK,
Como eu vou para KEYWORK,
Como eu chego a/ao KEYWORK,
Pode me acompanhar até KEYWORK,
EOF


intencoes_bob = intencoes_bob.gsub("\n","").split(',')
palavras_chaves_bob = palavras_chaves_bob.gsub("\n","").split(',')
perguntas_intencoes_bob = perguntas_intencoes_bob.gsub("\n","").split(',')
quantidade = intencoes_bob.size


CSV.open('our-new-customers-file.csv', 'w') do |csv_object|
  (0..quantidade-1).each do |i|
    intencao =  intencoes_bob[i]
    perguntas_intencoes_bob.each do |frase|
      csv_object << [frase.gsub("KEYWORK",palavras_chaves_bob[i]),intencao]
    end
  end
end
