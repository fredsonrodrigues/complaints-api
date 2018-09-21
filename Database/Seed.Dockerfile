FROM mongo:3.6.5

COPY company.json /company.json
COPY complaint.json /complaint.json
CMD mongoimport --host mongobase --db complaint --collection company --type json --file /company.json --jsonArray \
    && mongoimport --host mongobase --db complaint --collection complaint --type json --file /complaint.json --jsonArray