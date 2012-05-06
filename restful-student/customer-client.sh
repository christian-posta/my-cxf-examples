export URL="http://localhost:9000/CustomerService/customers/firstName=Joe&lastName=Bloggs"
export COMMAND="curl -X GET $URL"

echo Performing a HTTP get on $URL using curl
echo $COMMAND
echo Result = 
$COMMAND
