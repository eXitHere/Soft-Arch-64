import express, { Request, Response } from 'express';
import axios from 'axios';

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

let caching = { data: {}, timestamp: 0 };

app.get('/', async (req: Request, res: Response) => {
  console.log(new Date().getTime() - caching.timestamp);
  if (new Date().getTime() - caching.timestamp > 1000 * 60 * 2) {
    const timezone = await axios.get('http://worldtimeapi.org/api/timezone/');
    // console.log('fetch');
    caching = {
      data: timezone.data,
      timestamp: new Date().getTime(),
    };
  }
  res.send(caching);
});

app.delete('/', async (req: Request, res: Response) => {
  // console.log(new Date().getTime() - caching.timestamp);
  const timezone = await axios.get('http://worldtimeapi.org/api/timezone/');
  // console.log('fetch');
  caching = {
    data: timezone.data,
    timestamp: new Date().getTime(),
  };
  res.send(caching);
});

app.listen(5000, () => {
  console.log(`Server running at port 5000`);
});
