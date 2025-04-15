# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT *,
CASE WHEN dna_sequence LIKE 'ATG%' THEN 1 ELSE 0 END  has_start ,
CASE WHEN dna_sequence LIKE '%TGA' OR dna_sequence LIKE '%TAG' OR dna_sequence LIKE '%TAA'THEN 1 ELSE 0 END  has_stop,
CASE WHEN dna_sequence LIKE '%ATAT%' THEN 1 ELSE 0 END  has_atat,
CASE WHEN dna_sequence LIKE '%GGG%' THEN 1 ELSE 0 END  has_ggg
FROM Samples