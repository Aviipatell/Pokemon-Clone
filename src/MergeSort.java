/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */
//reference from http://www.snippetexample.com/2014/10/mergesort-implementation-example-using-arraylist-java/
//imports
import java.util.ArrayList;

public class MergeSort {
	//class body
	
	//declare some variables ima need / private instance variables :)
    private ArrayList<Integer> scoreArray;
    private ArrayList<String> nameArray;
     
    /**
     * accessor method for inputArray
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getSortedScoresArray() 
    { 
        return scoreArray;
    }
    
    /**
     * accessor method for nameArray
     * @return ArrayList<String>
     */
    public ArrayList<String> getSortedNamesArray() 
    {
        return nameArray;
    }
 
    /**
     * constructor for MergeSort
     * @param inputArray - ArrayList<Integer>
     * @param nameArray - ArrayList<String>
     */
    public MergeSort(ArrayList<Integer> inputArray, ArrayList<String> nameArray)
    {
        this.scoreArray = inputArray;
        this.nameArray = nameArray;
    }
    
    /**
     * method to sort the given arrays
     */
    public void sortGivenArray()
    {       
        divide(0, this.scoreArray.size()-1);
        divide(0, this.nameArray.size()-1);
    }
     
    /**
     * method to divide the arrays 
     * @param startIndex - int
     * @param endIndex - int
     */
    public void divide(int startIndex,int endIndex)
    {
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1)
        {
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);            
        }       
    }   
     
    /**
     * method to merge the arrays 
     * @param startIndex - int
     * @param midIndex - int
     * @param endIndex - int
     */
    public void merger(int startIndex,int midIndex,int endIndex){
         
        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
        ArrayList<String> sortedNamesArray = new ArrayList<String>();
         
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
         
        while(leftIndex<=midIndex && rightIndex<=endIndex)
        {
            if(scoreArray.get(leftIndex)<=scoreArray.get(rightIndex))
            {
                mergedSortedArray.add(scoreArray.get(leftIndex));
                sortedNamesArray.add(nameArray.get(leftIndex));
                leftIndex++;
            }
            else
            {
                mergedSortedArray.add(scoreArray.get(rightIndex));
                sortedNamesArray.add(nameArray.get(rightIndex));
                rightIndex++;
            }
        }       
         
        //Either of below while loop will execute
        while(leftIndex<=midIndex)
        {
            mergedSortedArray.add(scoreArray.get(leftIndex));
            sortedNamesArray.add(nameArray.get(leftIndex));
            leftIndex++;
        }
         
        while(rightIndex<=endIndex)
        {
            mergedSortedArray.add(scoreArray.get(rightIndex));
            sortedNamesArray.add(nameArray.get(rightIndex));
            rightIndex++;
        }
         
        int i = 0;
        int j = startIndex;
        int x = 0;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size())
        {
        	x = i++;
        	scoreArray.set(j, mergedSortedArray.get(x));
            nameArray.set(j, sortedNamesArray.get(x));
            j++;
        }
    }
}
