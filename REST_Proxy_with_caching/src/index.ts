import express, { Request, Response } from 'express';
import axios from 'axios';
import { Caching } from './caching';

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/', async (req: Request, res: Response) => {
  const cache = Caching.getInstance();
  if (new Date().getTime() - cache.getTimestamp() > 1000 * 60 * 2) {
    const timezone = await axios.get(
      'http://worldtimeapi.org/api/timezone/Asia/Bangkok',
    );
    // console.log('fetch');
    cache.set(timezone.data);
  }
  res.send(cache.getCache());
});

app.delete('/', async (req: Request, res: Response) => {
  const cache = Caching.getInstance();
  const timezone = await axios.get(
    'http://worldtimeapi.org/api/timezone/Asia/Bangkok',
  );
  // console.log('fetch');
  cache.set(timezone.data);
  res.send(cache.getCache());
});

app.listen(5000, () => {
  console.log(`Server running at port 5000`);
});
