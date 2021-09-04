package richard;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.io.FileReader;

public final class InfoBanco {

    public InfoBanco(Path in) {
        pastaBase = in;

    }

    private void guardaInfos(Path in, ListaDinamica<Object> lista) throws RuntimeException {
        try {
            DirectoryStream<Path> subarquivos = Files.newDirectoryStream(in);

            for (Path arquivos : subarquivos) {
                String nome = arquivos.getFileName().toString();

                if (nome.substring(nome.lastIndexOf('.')).equals(".txt")) {
                    String texto = "";

                    FileReader dadosArquivos = new FileReader(
                            arquivos.getParent() + "/" + arquivos.getFileName());

                    int character = 0;
                    while ((character = dadosArquivos.read()) != -1)
                        texto = texto.concat(String.valueOf((char) character));
                    

                    String array[] = {
                        nome.substring(0, nome.lastIndexOf('.') - 1),
                        texto};

                    listaBase.add(array);
                
                }
                
                
            }
        }
        catch (Exception e) {
            throw (RuntimeException) e;
        }
    }

    private final Path pastaBase;
    private ListaDinamica<Object> listaBase;
}
