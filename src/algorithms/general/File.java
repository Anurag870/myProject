/*class Challenge {


    private static int BLOCK_SIZE = 1024 ; // 1KB
    private static HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();

    static void dedup(String input_file_path, String deduped_file_path) {
        byte[] buffer = new byte[BLOCK_SIZE];
        File f = new File(input_file_path);
        File newFile = new File(deduped_file_path);
        String fileName = f.getName();
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            FileOutputStream out = new FileOutputStream(deduped_file_path);
            int bytesAmount = 0;
            int iteration = 1;

            while ((bytesAmount = bis.read(buffer)) > 0) {
                System.out.println("Iteration " + iteration);
                int hash = Arrays.hashCode(buffer);

                // If chunk is unique add to new file
                if (myMap.get(hash) == null){
                    try{
                        out.write(buffer, 0, bytesAmount);
                    } catch (Exception e){

                    }
                }
                myMap.computeIfAbsent(hash,  x -> new ArrayList<Integer>()).add(iteration);
                iteration++;
                System.out.println("HashCode: " + hash);
            }

            fis.close();
            bis.close();
            out.close();
        } catch (Exception e){

        }
        System.out.println("I size: " + f.length());
        System.out.println("F size: " + newFile.length());
    }


    static boolean redup(String dedup_file_path, String output_file_path) {
        byte[] buffer = new byte[BLOCK_SIZE];
        File f = new File(dedup_file_path);
        File newFile = new File(output_file_path);
        String fileName = f.getName();
        //System.out.println(fileName.length());
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            FileOutputStream out = new FileOutputStream(output_file_path);
            int bytesAmount = 0;
            int iteration = 1;

            while ((bytesAmount = bis.read(buffer)) > 0) {
                //System.out.println("Iteration 2 " + iteration);
                int hash = Arrays.hashCode(buffer);
                ArrayList<Integer> list = myMap.get(hash);
                if (list == null){
                    return false;
                }

                System.out.println("size: " + list.size());

                // Add chunk to multiple locations based on map
                for(Integer i : list){
                    try{

                        out.write(buffer, 0, bytesAmount);

                    } catch (Exception e){
                        return false;
                    }
                }

                iteration++;
            }

            fis.close();
            bis.close();
            out.close();
        } catch (Exception e){
            return false;
        }
        System.out.println("newFile: " + newFile.length());
        return true;
    }
}*/