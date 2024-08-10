import java.util.*;

public class DomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] subdomains = domain.split("\\.");
            String currentDomain = "";

            // Build subdomains from right to left
            for (int i = subdomains.length - 1; i >= 0; i--) {
                if (currentDomain.isEmpty()) {
                    currentDomain = subdomains[i];
                } else {
                    currentDomain = subdomains[i] + "." + currentDomain;
                }
                domainCountMap.put(currentDomain, domainCountMap.getOrDefault(currentDomain, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        DomainVisitCount dvc = new DomainVisitCount();
        String[] cpdomains1 = {"9001 discuss.leetcode.com"};
        String[] cpdomains2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(dvc.subdomainVisits(cpdomains1)); // Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
        System.out.println(dvc.subdomainVisits(cpdomains2)); // Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    }
}
