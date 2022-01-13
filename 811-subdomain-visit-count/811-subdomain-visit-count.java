class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // key: subdomain, value: frequency
        StringBuilder resultStringBuilder = new StringBuilder();

        for (String cpdomain : cpdomains) {
            int indexSpace = cpdomain.indexOf(' ');
            int numClicks = Integer.parseInt(cpdomain.substring(0, indexSpace));
            String domain = cpdomain.substring(indexSpace + 1);
            resultStringBuilder.setLength(0);
            resultStringBuilder.append(domain);
            while (true) {
                map.put(resultStringBuilder.toString(), map.getOrDefault(resultStringBuilder.toString(), 0) + numClicks);
                int dotPosition = resultStringBuilder.indexOf(".");
                if (dotPosition == -1)
                    break;
                resultStringBuilder.delete(0, dotPosition + 1);
            }
        }

        for (String domain : map.keySet())
            result.add(map.get(domain) + " " + domain);

        return result;
    }
}