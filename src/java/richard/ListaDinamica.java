package richard;

public class ListaDinamica<T> extends VetorDinamico<T> {
    public ListaDinamica(int capacity){
        super(capacity);
    }

    public ListaDinamica(){
        super(0);
    }

    public ListaDinamica(T... args){
        add(args);
    }

    public ListaDinamica add(T... args){
        //esta funcao prefere criar novos espacos em vez de atirar excecoes

        if(args.length > this.getCapacity())
            allocate(args.length);

        for(T argumento : args)
            arrayBase[length++] = argumento;


        return this;
    }

    public ListaDinamica set(T item, int position) throws RuntimeException{
        arrayBase[position] = item;
        length = (length <= position)? position + 1: length;

        return this;
    }
    
    @Override
    public String toString(){
        
        if(arrayBase instanceof Character[] || arrayBase instanceof Byte[]){
            
            char[] array = new char[length];
            
            for(int i=0; i < length; i++)
                array[i] = (Character)arrayBase[i];
                
            return new String(array);
        }
        
        else{
            String returning = "{";
            
            for(T printa : arrayBase)
                returning = returning.concat(printa + ", ");
            
            returning = returning.substring(0, returning.length() - 2);
            
            returning = returning.concat("}");
            
            return returning;
        }
    }
}
