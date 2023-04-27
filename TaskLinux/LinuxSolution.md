## 1. Создание директорий и наполнение их содержимым :


- mkdir toys_for_schoolchildren && touch toys_for_schoolchildren/robots.txt 
&& touch toys_for_schoolchildren/designer_toy.txt 
&& touch toys_for_schoolchildren/table_games.txt

 - mkdir toys_for_preschool_children && touch     toys_for_preschool_children/soft_toy.txt 
&& touch toys_for_preschool_children/dolls.txt 
&& touch toys_for_preschool_children/cars.txt


## 2. Обьединение директорий в одну с именем name_toys
- cp -r toys_for_preschool_children/* toys_for_schoolchildren/ && mv toys_for_schoolchildren/ name_toys

## 3. Переименование директории

- mv name_toys/ toys
## 4. Просмотр содержимого директории
- sl -R

 >blackbirdxx@blackbirdxx:~/certification$ ls -R
.:
toys  toys_for_preschool_children

>./toys:

>cars.txt  designer_toy.txt  dolls.txt  robots.txt  soft_toy.txt  table_games.txt

>./toys_for_preschool_children:

>cars.txt  dolls.txt  soft_toy.txt

## 5. Установка и удаление snap-пакета
- snap find
- snap find foobar2000
- sudo snap install foobar2000
>foobar2000 1.6.16 from Taqi Raza (mmtrt) installed
- foobar2000
>Starting application..
- sudo snap remove foobar2000
>foobar2000 removed

## 6. Команда для выполнения каждые 3 минуты (запись в фаилы)

- crontab -e
- (Сама команда)
>*/3 * * * * echo 'New car' >> /home/blackbirdxx/certification/toys/cars.txt 
&& echo 'New doll' >> /home/blackbirdxx/cetification/toys/dolls.txt