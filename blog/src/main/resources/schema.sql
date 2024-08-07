-- Drop the table if it exists
DROP TABLE IF EXISTS Run;

-- Create the table
CREATE TABLE Run (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    started_on TIMESTAMP NOT NULL,
    completed_on TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    version INT
);
