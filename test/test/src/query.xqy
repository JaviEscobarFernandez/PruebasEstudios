<result>
{
    if (not(doc(“libros.xml”))) then (
        <error>
            <message>El fichero libros.xml no existe</message>
        </error>
    )
    else (
        for $x in doc(“libros.xml”)/books/book
        where $x/precio>30
        return $x/titulo
    )
}
