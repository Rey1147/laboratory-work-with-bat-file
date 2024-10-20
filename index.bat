@echo off
chcp 65001 >nul
echo Автор: Rey1.0.0, Курс 3, Группа 147

if not exist Main.class (
    echo Исполняемый файл не найден. Пожалуйста, скомпилируйте файл
    goto :end
)

if not exist file.txt (
    echo Текстовый файл не найден
    goto :end
)

if "%1"=="" (
    set dir_name=C:\Temp
) else (
    set dir_name=%1
)

if not exist "%dir_name%" (
    mkdir "%dir_name%"
    echo Создан каталог "%dir_name%"
) else (
    echo Каталог "%dir_name%" уже существует
)

java Main "file.txt" "%dir_name%"
if errorlevel 1 (
    echo Программа завершилась с ошибкой
) else (
    echo Программа завершена успешно
)

echo Код завершения программы: %errorlevel%
if %errorlevel%==0 (
    echo Все прошло успешно
) else (
    echo Возникла ошибка
)

:end
echo Завершение работы командного файла
exit /b



