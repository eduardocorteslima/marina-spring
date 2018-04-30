require 'csv'

# CSV.foreach('customers.csv') do |row|
#     puts row.inspect
#   end


# intent = ["acompanhar_ate_biblioteca", "acompanhar_ate_banheiro", "acompanhar_ate_secretaria"]


# while a = gets
#   unless a.nil?
#     a.gsub!(/LOCAL_DE_DESTINO/,'biblioteca').chop!
#     intent.each do |i|  
#       puts "#{a}, #{i}"
#     end
#   end
# end
# palavras = <<EOS
# tiago domingos cipriano
# que tal mais palavras
# EOS

intencoes_saber_nota = ["saber-nota-prova","saber-nota-semestre","saber-nota-geral","saber-nota-diciplina"]
intencoes_locais = ["ir-a-biblioteca","ir-ate-secretaria", "ir-ate-cordenacao"]
peguntas = ["Como eu chego a/ao", "pode me levar até", "caminho para"]



CSV.open('our-new-customers-file.csv', 'w') do |csv_object|
    intencoes_locais.each do |intention|
        peguntas.each do |pergunta|
            csv_object << [pergunta,intention]
        end
    end
    # customers.each do |row_array|
    #     csv_object << row_array
    # end
end